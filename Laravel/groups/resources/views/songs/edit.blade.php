@extends('layout')
@section('contenuto')
<form method="POST" action="/songs/{{$song->id}}">
    @csrf
    @method('PUT')
    <input type="text" name="nome">
    <input type="submit" value="Modifica">
</form>
@endsection