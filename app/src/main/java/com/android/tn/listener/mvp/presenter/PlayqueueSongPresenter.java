package com.android.tn.listener.mvp.presenter;

import java.util.List;

import com.android.tn.listener.Constants;
import com.android.tn.listener.mvp.contract.PlayqueueSongContract;
import com.android.tn.listener.mvp.model.Song;
import com.android.tn.listener.mvp.usecase.GetSongs;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by hefuyi on 2016/12/27.
 */

public class PlayqueueSongPresenter implements PlayqueueSongContract.Presenter{

    private GetSongs mUsecase;
    private PlayqueueSongContract.View mView;
    private CompositeSubscription mCompositeSubscription;

    public PlayqueueSongPresenter(GetSongs getSongs) {
        mUsecase = getSongs;
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void attachView(PlayqueueSongContract.View view) {
        mView = view;
    }

    @Override
    public void subscribe() {
        loadSongs();
    }

    @Override
    public void unsubscribe() {
        mCompositeSubscription.clear();
    }

    @Override
    public void loadSongs() {
        Subscription subscription = mUsecase.execute(new GetSongs.RequestValues(Constants.NAVIGATE_QUEUE))
                .getSongList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Song>>() {
                    @Override
                    public void call(List<Song> songs) {
                        mView.showSongs(songs);
                    }
                });
        mCompositeSubscription.add(subscription);
    }
}
