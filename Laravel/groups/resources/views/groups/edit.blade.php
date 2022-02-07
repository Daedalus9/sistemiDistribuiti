@extends('layout')
@section('contenuto')
<form method="POST" action="/groups/{{$group->id}}">
    @csrf
    @method('PUT')
    <input type="text" name="nome">
    <input type="submit" value="Modifica">
</form>
@endsection