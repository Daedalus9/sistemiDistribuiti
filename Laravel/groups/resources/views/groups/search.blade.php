@extends('layout')
@section('contenuto')
@foreach ($searchGroup as $s)

   <ul><li><a href="/groups/{{$s->id}}">{{$s->nome}}</a></li></ul> 
@endforeach
@endsection