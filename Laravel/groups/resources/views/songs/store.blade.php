@extends('layout')
@section('contenuto')
<form method="post" action="/songs">
    @csrf
    <input type="text" name="nome">
    <input type="number" name="group_id" placeholder="ID gruppo">
    <input type="submit" value="Inserisci">
</form>
@endsection