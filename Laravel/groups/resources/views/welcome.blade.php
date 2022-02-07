@extends('layout')
@section('contenuto')
<form method="get" action="/groups/create">
    <input type="submit" value="Inserisci gruppo">
</form>
<br><br>
<form method="get" action="/showAll">
    <input type="submit" value="Visualizza tutti i gruppi">
</form>
<br><br>
<form method="get" action="/songs/create">
    <input type="submit" value="Inserisci canzone">
</form>
<br><br>
<form method="get" action="/showAllSongs">
    <input type="submit" value="Visualizza tutte le canzoni">
</form>
<br><br>
<h1>Cerca gruppo:</h1>
<form method="get" action="/searchGroup">
    <input type="text" name="nome">
    <input type="submit" value="Cerca gruppo">
</form>
<br><br>
<h1>Cerca brano:</h1>
<form method="get" action="/searchSong">
    <input type="text" name="nome">
    <input type="submit" value="Cerca brano">
</form>
<br><br>
@endsection