package com.android.zj.listener.mvp.contract;

import android.content.Context;

import java.util.List;

import com.android.zj.listener.mvp.model.FolderInfo;
import com.android.zj.listener.mvp.presenter.BasePresenter;
import com.android.zj.listener.mvp.view.BaseView;

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
