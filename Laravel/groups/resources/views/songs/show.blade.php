@extends('layout')
@section('contenuto')
Nome: {{$song->nome}} <br><br>
Gruppo:
<ul><li><a href="/groups/{{$song->group->id}}">{{$song->group->nome}}</a></li></ul> 
<br><br>
<form method="get" action="/songs/{{$song->id}}/edit">
    <input type="submit" value="Modifica brano">
</form>
<br>
<form method="POST" action="/songs/{{$song->id}}">
    @csrf
    @method('DELETE')
    <input type="submit" value="Elimina brano">
</form>

@endsection