package com.android.tn.listener.mvp.contract;

import android.content.Context;

import java.util.List;

import com.android.tn.listener.mvp.model.FolderInfo;
import com.android.tn.listener.mvp.presenter.BasePresenter;
import com.android.tn.listener.mvp.view.BaseView;

/**
 * Created by hefuyi on 2016/12/11.
 */

public interface FoldersContract {

    interface View extends BaseView{

        Context getContext();

        void showEmptyView();

        void showFolders(List<FolderInfo> folderInfos);
    }

    interface Presenter extends BasePresenter<View> {

        void loadFolders();
    }
}
