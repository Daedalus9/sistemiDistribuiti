<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\GroupsController;
use App\Http\Controllers\SongsController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Route::resource('/groups', GroupsController::class);
Route::resource('/songs', SongsController::class);
Route::get('/showAll', [GroupsController::class, 'showAll']);
Route::get('/showAllSongs', [SongsController::class, 'showAll']);
Route::get('/searchGroup', [GroupsController::class, 'search']);
Route::get('/searchSong', [SongsController::class, 'search']);