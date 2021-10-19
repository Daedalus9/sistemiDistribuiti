#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <unistd.h>
#include <string.h>

const int PORT = 7777;
const int BUFFER_SIZE = 124;
const int OPERATION_SIZE = 5;
const char *ERROR_MESSAGE = "ERROR\n";

int conto[10];

int bankAccount = -1;

void setBankAccount(char *operation) {
    bankAccount = (int) operation[1] - '0';
    printf("Bank account set to %d \n", bankAccount);
    return;
}

void deposit(char *operation, int clientSocketDescriptor) {
    char value[4];
    int j = 0;
    int i = 1;
    while(i<5) {
        if(operation[i] >='0' && operation[i] <='9') {
            value[j]=operation[i];
            j++;
        }
        ++i;
    }
    if(j==4 && bankAccount!=-1) {
        conto[bankAccount] += atoi(value);
        printf("Deposit operation on bank account %d with value: %s\n", bankAccount, value);
    }
    else write(clientSocketDescriptor, ERROR_MESSAGE, sizeof(ERROR_MESSAGE));
    
    return;
}

void withdraw(char *operation, int clientSocketDescriptor) {
    char value[4];
    int j = 0;
    int i = 1;
    while(i<5) {
        if(operation[i] >='0' && operation[i] <='9') {
            value[j]=operation[i];
            j++;
        }
        ++i;
    }
    if(j==4 && bankAccount!=-1) {
        /*
        char *errorMessageOnWithdraw = "Unable to withdraw: You do not have the required balance\n";
        int tmp = atoi(value);
        if(conto[bankAccount] - tmp < 0) {
            write(clientSocketDescriptor, errorMessageOnWithdraw, strlen(errorMessageOnWithdraw));
            printf("Invalid withdrawal operation on bank account %d with value %s: Negative balance", bankAccount, value);
        }
        else conto[bankAccount] -= atoi(value);
        */
        conto[bankAccount] -= atoi(value);
        printf("Withdrawal operation on bank account %d with value: %s\n", bankAccount, value);
    }
    else write(clientSocketDescriptor, ERROR_MESSAGE, sizeof(ERROR_MESSAGE));
    
    return;
}

void getBalance(char *operation, int clientSocketDescriptor) {
   if(bankAccount!=-1) {
    char *balanceMessage;
    sprintf(balanceMessage, "Current balace on account %d: %d\n", bankAccount, conto[bankAccount]);
    write(clientSocketDescriptor, balanceMessage, strlen(balanceMessage));
   }
   else {
       char *errorMessageOnGetBalance = "Unable to find balance: account not set\n";
       write(clientSocketDescriptor, errorMessageOnGetBalance, strlen(errorMessageOnGetBalance));
   }
   return;
}

int main() {

    struct sockaddr_in address;
    address.sin_addr.s_addr = INADDR_ANY;
    address.sin_port = htons(PORT);
    address.sin_family = AF_INET;

    printf("Starting server on port %d\n", PORT);

    socklen_t addressLenght = sizeof(address);

    int serversocketDescriptor = socket(AF_INET, SOCK_STREAM, 0);
    if(serversocketDescriptor == -1) {
        perror("Unable to initiaize socket");
        exit(1);
    }

    setsockopt(serversocketDescriptor, SOL_SOCKET, SO_REUSEADDR, &(int){1}, sizeof(int));

    int tryingBind = bind(serversocketDescriptor,(struct sockaddr*) &address, addressLenght);
    if(tryingBind == -1) {
        perror("Error on bind");
        exit(1);
    }

    int tryingListen = listen(serversocketDescriptor, 1);
    if(tryingListen == -1) {
        perror("Error on listen");
        exit(1);
    }

    while(1) {
        int clientSocketDescriptor = accept(serversocketDescriptor, NULL, NULL);
        if(clientSocketDescriptor == -1) {
            perror("Error on accept");
            exit(1);
        }

        char buffer[BUFFER_SIZE];
        memset(buffer, 0, sizeof(buffer));
        ssize_t currentBytesRead = 0;
        ssize_t totalBytesRead = 0;

        do {
            int currentBytesRead = read(clientSocketDescriptor, buffer + totalBytesRead, sizeof(buffer) - totalBytesRead);
            totalBytesRead += currentBytesRead;
            if(currentBytesRead == -1) {
                perror("Error on read");
                return -1;
            }
        }while(buffer[totalBytesRead -1]!='\n');
        
        char operation[OPERATION_SIZE];
        sscanf(buffer, "%s", operation);

        if(operation[0]=='U' && strlen(operation) == 2 && operation[1] >= '0' && operation[1] <= '9') 
            setBankAccount(operation);

        else if(operation[0]=='V' && strlen(operation) == 5)
            deposit(operation, clientSocketDescriptor);

        else if(operation[0]=='P' && strlen(operation) == 5)
            withdraw(operation, clientSocketDescriptor);
        
        else if(operation[0]=='S' && strlen(operation) == 1) {
            getBalance(operation, clientSocketDescriptor);
        }

        else
            write(clientSocketDescriptor, ERROR_MESSAGE, sizeof(ERROR_MESSAGE));

        close(clientSocketDescriptor);
    }
}