package com.naveenkumarrm.moveX.feature.loader;

import com.naveenkumarrm.moveX.data.dto.LoaderDTO;
import com.naveenkumarrm.moveX.util.ConsoleInput;

public class LoaderView {

    private final LoaderModel loaderModel;
    private final ConsoleInput consoleInput;

    public LoaderView() {
        this.loaderModel = new LoaderModel(this);
        this.consoleInput = ConsoleInput.getInstance();
    }

    public void init() {
        System.out.println("---- Add Loader ----");
        String name = consoleInput.readText("Loader name: ");
        String mobileNo = consoleInput.readText("Loader mobile: ");

        loaderModel.createLoader(name, mobileNo);
    }

    public void onLoaderCreated(LoaderDTO loader) {
        System.out.println("Loader created with id " + loader.getId());
    }
}
