<?php

namespace App\Http\Controllers;

use App\Models\Group;
use Illuminate\Http\Request;

class GroupsController extends Controller
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
        
        return view('groups.store');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $group = new Group;
        $group->nome=request('nome');
        $group->save();
        $home = '<a href="/">Home</a>';
        return "Gruppo " . $group->nome . " inserito nel database. <br><br>" . $home;
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Group  $group
     * @return \Illuminate\Http\Response
     */
    public function show(Group $group)
    {
        return view('groups.show', compact('group'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Group  $group
     * @return \Illuminate\Http\Response
     */
    public function edit(Group $group)
    {
        return view('groups.edit', compact('group'));
        
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Group  $group
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Group $group)
    {
        $oldName=$group->nome;
        $group->nome=request('nome');
        $group->save();
        $home = '<a href="/">Home</a>';
        return "Gruppo " . $oldName . " modificato. Nuovo nome: " . $group->nome . " <br><br>" . $home;
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Group  $group
     * @return \Illuminate\Http\Response
     */
    public function destroy(Group $group)
    {
        $delGroup=$group->nome;
        $group->delete();
        $home = '<a href="/">Home</a>';
        return "Gruppo " . $delGroup . " eliminato dal database. <br><br>" . $home;
    }

    public function showAll() {
        $groups = Group::all();
        return view('groups.showAll', compact('groups'));
    }

    public function search(Request $request){
        $searchRequest = request('nome');
        $searchGroup = Group::where('nome', 'LIKE', '%'.$searchRequest.'%')->get();

        return view('groups.search', compact('searchGroup'));
    }
}
