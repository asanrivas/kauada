/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.yeayyy.kauada;

import android.os.Bundle;
import org.apache.cordova.*;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.PushService;

public class cordovaExample extends DroidGap
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Set by <content src="index.html" /> in config.xml
        super.loadUrl(Config.getStartUrl());
        //super.loadUrl("file:///android_asset/www/index.html")
        
        //
        Parse.initialize(this, "l3u5f6gZsv89a09Ie6ZjXqxgz4BNcoH4llwfTkfB", "XTJFNCa19l2hBoWbKQeDWCZfUpybfsfeXmwGUZue");
        
        PushService.setDefaultPushCallback(this, cordovaExample.class);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        

        // To track statistics around application opens
        ParseAnalytics.trackAppOpened(getIntent());
        
        
        //subscribe 
        PushService.subscribe(this, "cars", cordovaExample.class);
        PushService.subscribe(this, "motorcycles", cordovaExample.class);
        PushService.subscribe(this, "apartments", cordovaExample.class);
        PushService.subscribe(this, "houses", cordovaExample.class);
    }
}

