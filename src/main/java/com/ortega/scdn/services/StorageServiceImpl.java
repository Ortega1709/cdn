package com.ortega.scdn.services;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.ortega.scdn.utils.Constant.ACCESS_KEY;
import static com.ortega.scdn.utils.Constant.SECRET_KEY;

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    private final AmazonS3 amazonS3;

    public StorageServiceImpl() {

        AWSCredentials credentials = new BasicAWSCredentials(
                ACCESS_KEY,
                SECRET_KEY
        );

        amazonS3 = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.EU_NORTH_1)
                .build();
    }
}
