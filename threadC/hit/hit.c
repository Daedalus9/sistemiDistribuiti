/* Una variabile intera x, inizializzata a 0, è condivisa tra 2 thread tA, tB. Ogni thread dispone di una variabile locale hit ed esegue le seguenti azioni:

- attende un numero casuale di ms (N.B.: la chiamata usleep(n) attende per n microsecondi)
- se la variabile condivisa x > 500, allora scrive su stdout il valore di hit e termina la propria esecuzione
- altrimenti, incrementa x, incrementa la variabile locale hit e ricomincia da (1)

Il programma termina quando tutti i thread hanno terminato la propria esecuzione.
Nel codice, proteggere opportunamente la variabile x dagli accessi concorrenti. */

#include <pthread.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>

int x = 0;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

void hit(void * arg) {
    printf("Sono il thread %s: ", (char *) arg);
    for(int i=0; ;i++) {
        usleep((rand()%10000 + 1) + 500);
        pthread_mutex_lock(&mutex);
        if(x>=500) {
            printf("Thread %s: x = %d, hit = %d\n", (char *) arg, x, i);
            pthread_mutex_unlock(&mutex);
            pthread_exit(NULL);
        }
        else {
            if((char *) arg==(char *) "A") printf("Thread %s: x = %d\n", (char *) arg, x);
            else printf("\t\t\tThread %s: x = %d\n", (char *) arg, x);
            x++;
        }
        pthread_mutex_unlock(&mutex);
    }
    pthread_mutex_lock(&mutex);
    
}

int main() {
    pthread_t tA, tB;
    srand(time(NULL));

    pthread_create(&tA, NULL, (void *) &hit, (void *) "A");
    pthread_create(&tB, NULL, (void *) &hit, (void *) "B");

    pthread_join(tA, NULL);
    pthread_join(tB, NULL);

    return 0;
}