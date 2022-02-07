@extends('layout')
@section('contenuto')
@foreach ($songs as $s)

   <ul><li><a href="/songs/{{$s->id}}">{{$s->nome}}</a></li></ul> 
@endforeach
@endsection