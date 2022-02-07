@extends('layout')
@section('contenuto')
Nome: {{$group->nome}} <br><br>
ID: {{$group->id}} <br><br>

@if (count($group->songs))
Brani:
@foreach ($group->songs as $s)
<ul><li><a href="/songs/{{$s->id}}">{{$s->nome}}</a></li></ul> 

@endforeach
@endif
<br><br>
<form method="get" action="/groups/{{$group->id}}/edit">
    <input type="submit" value="Modifica gruppo">
</form>
<br>
<form method="POST" action="/groups/{{$group->id}}">
    @csrf
    @method('DELETE')
    <input type="submit" value="Elimina gruppo">
</form>

@endsection