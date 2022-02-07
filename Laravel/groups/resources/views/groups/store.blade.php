@extends('layout')
@section('contenuto')
<form method="post" action="/groups">
    @csrf
    <input type="text" name="nome">
    <input type="submit" value="Inserisci">
</form>
@endsection