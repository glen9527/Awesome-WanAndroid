package json.chao.com.wanandroid.presenter.hierarchy;

import javax.inject.Inject;

import json.chao.com.wanandroid.component.RxBus;
import json.chao.com.wanandroid.core.DataManager;
import json.chao.com.wanandroid.base.presenter.BasePresenter;
import json.chao.com.wanandroid.contract.hierarchy.KnowledgeHierarchyDetailContract;
import json.chao.com.wanandroid.core.event.DismissDetailErrorView;
import json.chao.com.wanandroid.core.event.ShowDetailErrorView;

/**
 * @author quchao
 * @date 2018/2/23
 */

public class KnowledgeHierarchyDetailPresenter extends BasePresenter<KnowledgeHierarchyDetailContract.View>
        implements KnowledgeHierarchyDetailContract.Presenter {

    private DataManager mDataManager;

    @Inject
    KnowledgeHierarchyDetailPresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(KnowledgeHierarchyDetailContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {
        addSubscribe(RxBus.getDefault().toFlowable(DismissDetailErrorView.class)
                .subscribe(dismissDetailErrorView -> mView.showDismissDetailErrorView()));

        addSubscribe(RxBus.getDefault().toFlowable(ShowDetailErrorView.class)
                .subscribe(showDetailErrorView -> mView.showDetailErrorView()));
    }


}
