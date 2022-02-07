<?php

namespace App\Http\Controllers;

use App\Models\Song;
use App\Models\Group;
use Illuminate\Http\Request;

class SongsController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('songs.store');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $song = new Song;
        $song->nome=request('nome');
        $song->group_id=request('group_id');
        Group::findOrFail($song->group_id);
        $song->save();
        $home = '<a href="/">Home</a>';
        return "Brano " . $song->nome . " inserito nel database. <br>" . $home;
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Song  $song
     * @return \Illuminate\Http\Response
     */
    public function show(Song $song)
    {
        return view('songs.show', compact('song'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Song  $song
     * @return \Illuminate\Http\Response
     */
    public function edit(Song $song)
    {
        return view('songs.edit', compact('song'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Song  $song
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Song $song)
    {
        $oldName=$song->nome;
        $song->nome=request('nome');
        $song->save();
        $home = '<a href="/">Home</a>';
        return "Brano " . $oldName . " modificato. Nuovo nome: " . $song->nome . " <br><br>" . $home;
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Song  $song
     * @return \Illuminate\Http\Response
     */
    public function destroy(Song $song)
    {
        $delSong=$song->nome;
        $song->delete();
        $home = '<a href="/">Home</a>';
        return "Brano " . $delSong . " eliminato dal database. <br><br>" . $home;
    }

    public function showAll() {
        $songs = Song::all();
        return view('songs.showAll', compact('songs'));
    }

    public function search(Request $request) {
        $searchRequest = request('nome');
        $searchSong = Song::where('nome', 'LIKE', '%'.$searchRequest.'%')->get();

        return view('songs.search', compact('searchSong'));
    }
}
