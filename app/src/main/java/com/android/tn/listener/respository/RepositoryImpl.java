package com.android.tn.listener.respository;

import android.content.Context;

import java.io.File;
import java.util.List;

import com.android.tn.listener.R;
import com.android.tn.listener.api.KuGouApiService;
import com.android.tn.listener.api.LastFmApiService;
import com.android.tn.listener.api.model.ArtistInfo;
import com.android.tn.listener.api.model.KuGouRawLyric;
import com.android.tn.listener.api.model.KuGouSearchLyricResult;
import com.android.tn.listener.dataloader.AlbumLoader;
import com.android.tn.listener.dataloader.AlbumSongLoader;
import com.android.tn.listener.dataloader.ArtistAlbumLoader;
import com.android.tn.listener.dataloader.ArtistLoader;
import com.android.tn.listener.dataloader.ArtistSongLoader;
import com.android.tn.listener.dataloader.FolderLoader;
import com.android.tn.listener.dataloader.LastAddedLoader;
import com.android.tn.listener.dataloader.PlaylistLoader;
import com.android.tn.listener.dataloader.PlaylistSongLoader;
import com.android.tn.listener.dataloader.QueueLoader;
import com.android.tn.listener.dataloader.SongLoader;
import com.android.tn.listener.dataloader.TopTracksLoader;
import com.android.tn.listener.mvp.model.Album;
import com.android.tn.listener.mvp.model.Artist;
import com.android.tn.listener.mvp.model.FolderInfo;
import com.android.tn.listener.mvp.model.Playlist;
import com.android.tn.listener.mvp.model.Song;
import com.android.tn.listener.respository.interfaces.Repository;
import com.android.tn.listener.util.LyricUtil;

import retrofit2.Retrofit;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hefuyi on 2016/11/3.
 */

public class RepositoryImpl implements Repository {

    private KuGouApiService mKuGouApiService;
    private LastFmApiService mLastFmApiService;
    private Context mContext;

    public RepositoryImpl(Context context, Retrofit kugou, Retrofit lastfm) {
        mContext = context;
        mKuGouApiService = kugou.create(KuGouApiService.class);
        mLastFmApiService = lastfm.create(LastFmApiService.class);
    }

    @Override
    public Observable<ArtistInfo> getArtistInfo(String artist) {
        return mLastFmApiService.getArtistInfo(artist);
    }

    @Override
    public Observable<File> downloadLrcFile(final String title, final String artist, final long duration) {
        return mKuGouApiService.searchLyric(title, String.valueOf(duration))
                .subscribeOn(Schedulers.io())
                .flatMap(new Func1<KuGouSearchLyricResult, Observable<KuGouRawLyric>>() {
                    @Override
                    public Observable<KuGouRawLyric> call(KuGouSearchLyricResult kuGouSearchLyricResult) {
                        if (kuGouSearchLyricResult.status == 200
                                && kuGouSearchLyricResult.candidates != null
                                && kuGouSearchLyricResult.candidates.size() != 0) {
                            KuGouSearchLyricResult.Candidates candidates = kuGouSearchLyricResult.candidates.get(0);
                            return mKuGouApiService.getRawLyric(candidates.id, candidates.accesskey);
                        } else {
                            return Observable.just(null);
                        }
                    }
                })
                .map(new Func1<KuGouRawLyric, File>() {
                    @Override
                    public File call(KuGouRawLyric kuGouRawLyric) {
                        if (kuGouRawLyric == null) {
                            return null;
                        }
                        String rawLyric = LyricUtil.decryptBASE64(kuGouRawLyric.content);
                        return LyricUtil.writeLrcToLoc(title, artist, rawLyric);
                    }
                });
    }

    @Override
    public Observable<List<Album>> getAllAlbums() {
        return AlbumLoader.getAllAlbums(mContext);
    }

    @Override
    public Observable<Album> getAlbum(long id) {
        return AlbumLoader.getAlbum(mContext, id);
    }

    @Override
    public Observable<List<Album>> getAlbums(String paramString) {
        return AlbumLoader.getAlbums(mContext, paramString);
    }

    @Override
    public Observable<List<Song>> getSongsForAlbum(long albumID) {
        return AlbumSongLoader.getSongsForAlbum(mContext, albumID);
    }

    @Override
    public Observable<List<Album>> getAlbumsForArtist(long artistID) {
        return ArtistAlbumLoader.getAlbumsForArtist(mContext, artistID);
    }

    @Override
    public Observable<List<Artist>> getAllArtists() {
        return ArtistLoader.getAllArtists(mContext);
    }

    @Override
    public Observable<Artist> getArtist(long artistID) {
        return ArtistLoader.getArtist(mContext, artistID);
    }

    @Override
    public Observable<List<Artist>> getArtists(String paramString) {
        return ArtistLoader.getArtists(mContext, paramString);
    }

    @Override
    public Observable<List<Song>> getSongsForArtist(long artistID) {
        return ArtistSongLoader.getSongsForArtist(mContext, artistID);
    }

    @Override
    public Observable<List<Song>> getRecentlyAddedSongs() {
        return LastAddedLoader.getLastAddedSongs(mContext);
    }

    @Override
    public Observable<List<Album>> getRecentlyAddedAlbums() {
        return LastAddedLoader.getLastAddedAlbums(mContext);
    }

    @Override
    public Observable<List<Artist>> getRecentlyAddedArtists() {
        return LastAddedLoader.getLastAddedArtist(mContext);
    }

    @Override
    public Observable<List<Song>> getRecentlyPlayedSongs() {
        return TopTracksLoader.getTopRecentSongs(mContext);
    }

    @Override
    public Observable<List<Album>> getRecentlyPlayedAlbums() {
        return AlbumLoader.getRecentlyPlayedAlbums(mContext);
    }

    @Override
    public Observable<List<Artist>> getRecentlyPlayedArtist() {
        return ArtistLoader.getRecentlyPlayedArtist(mContext);
    }

    @Override
    public Observable<List<Playlist>> getPlaylists(boolean defaultIncluded) {
        return PlaylistLoader.getPlaylists(mContext, defaultIncluded);
    }

    @Override
    public Observable<List<Song>> getSongsInPlaylist(long playlistID) {
        return PlaylistSongLoader.getSongsInPlaylist(mContext, playlistID);
    }

    @Override
    public Observable<List<Song>> getQueueSongs() {
        return QueueLoader.getQueueSongs(mContext);
    }

    @Override
    public Observable<List<Song>> getFavourateSongs() {
        return SongLoader.getFavoriteSong(mContext);
    }

    @Override
    public Observable<List<Album>> getFavourateAlbums() {
        return AlbumLoader.getFavourateAlbums(mContext);
    }

    @Override
    public Observable<List<Artist>> getFavourateArtist() {
        return ArtistLoader.getFavouriteArtists(mContext);
    }

    @Override
    public Observable<List<Song>> getAllSongs() {
        return SongLoader.getAllSongs(mContext);
    }

    @Override
    public Observable<List<Song>> searchSongs(String searchString) {
        return SongLoader.searchSongs(mContext, searchString);
    }

    @Override
    public Observable<List<Song>> getTopPlaySongs() {
        return TopTracksLoader.getTopPlaySongs(mContext);
    }

    @Override
    public Observable<List<FolderInfo>> getFoldersWithSong() {
        return FolderLoader.getFoldersWithSong(mContext);
    }

    @Override
    public Observable<List<Song>> getSongsInFolder(String path) {
        return SongLoader.getSongListInFolder(mContext, path);
    }

    @Override
    public Observable<List<Object>> getSearchResult(String queryString) {
        Observable<Song> songList = SongLoader.searchSongs(mContext, queryString)
                .flatMap(new Func1<List<Song>, Observable<Song>>() {
                    @Override
                    public Observable<Song> call(List<Song> songs) {
                        return Observable.from(songs);
                    }
                });

        Observable<Album> albumList = AlbumLoader.getAlbums(mContext, queryString)
                .flatMap(new Func1<List<Album>, Observable<Album>>() {
                    @Override
                    public Observable<Album> call(List<Album> albums) {
                        return Observable.from(albums);
                    }
                });

        Observable<Artist> artistList = ArtistLoader.getArtists(mContext, queryString)
                .flatMap(new Func1<List<Artist>, Observable<Artist>>() {
                    @Override
                    public Observable<Artist> call(List<Artist> artistList) {
                        return Observable.from(artistList);
                    }
                });

        Observable<String> songHeader = Observable.just(mContext.getString(R.string.songs));
        Observable<String> albumHeader = Observable.just(mContext.getString(R.string.albums));
        Observable<String> artistHeader = Observable.just(mContext.getString(R.string.artists));

        return Observable.merge(songHeader, songList, albumHeader, albumList, artistHeader, artistList).toList();
    }
}
