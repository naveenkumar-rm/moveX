package com.naveenkumarrm.moveX.feature.loader;

import com.naveenkumarrm.moveX.data.dto.LoaderDTO;
import com.naveenkumarrm.moveX.data.repository.MoveXDB;

public class LoaderModel {

    private final LoaderView loaderView;

    public LoaderModel(LoaderView loaderView) {
        this.loaderView = loaderView;
    }

    public void createLoader(String name, String mobileNo) {
        LoaderDTO loader = new LoaderDTO();
        loader.setId(MoveXDB.getInstance().getNextLoaderId());
        loader.setName(name);
        loader.setMobileNo(mobileNo);
        loader.setStatus("ACTIVE");
        loader.setCreatedAt(System.currentTimeMillis());

        MoveXDB.getInstance().addLoader(loader);
        loaderView.onLoaderCreated(loader);
    }
}
