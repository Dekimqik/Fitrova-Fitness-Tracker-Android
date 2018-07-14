package com.fitness.fitrova.model;

/**
 * Created by lion on 4/14/16.
 */
public interface Config {

    String SDCARD_DIRECTORY = "/coupon";

    String IMAGE_DIRECTORY = SDCARD_DIRECTORY + "/images";

    int IMAGE_CAMERA                = 100;
    int IMAGE_GALLERY               = 101;
    int CROP_IMAGE                  = 102;
    int MICROPHONE_ACCESS           = 103;

}
