@extends('layout')
@section('contenuto')
@foreach ($searchSong as $s)

   <ul><li><a href="/songs/{{$s->id}}">{{$s->nome}}</a></li></ul> 
@endforeach
@endsection