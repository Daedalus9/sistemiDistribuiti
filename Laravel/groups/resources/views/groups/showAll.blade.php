@extends('layout')
@section('contenuto')
@foreach ($groups as $g)

   <ul><li><a href="/groups/{{$g->id}}">{{$g->nome}}</a></li></ul> 
@endforeach
@endsection