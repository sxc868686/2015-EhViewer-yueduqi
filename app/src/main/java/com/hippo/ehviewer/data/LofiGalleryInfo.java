/*
 * Copyright (C) 2014 Hippo Seven
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hippo.ehviewer.data;

import android.os.Parcel;
import android.os.Parcelable;

public class LofiGalleryInfo extends GalleryInfo {

    /**
     * It could be null, please check before use.
     */
    public String[] lofiTags;

    public static final Parcelable.Creator<LofiGalleryInfo> CREATOR =
            new Parcelable.Creator<LofiGalleryInfo>() {
                @Override
                public LofiGalleryInfo createFromParcel(Parcel source) {
                    int length;

                    LofiGalleryInfo p = new LofiGalleryInfo();
                    p.gid = source.readInt();
                    p.token = source.readString();
                    p.title = source.readString();
                    p.posted = source.readString();
                    p.category = source.readInt();
                    p.thumb = source.readString();
                    p.uploader = source.readString();
                    p.rating = source.readFloat();
                    p.simpleLanguage = source.readString();

                    length = source.readInt();
                    if (length > 0) {
                        p.lofiTags = new String[length];
                        for (int i = 0; i < length; i++)
                            p.lofiTags[i] = source.readString();
                    }

                    return p;
                }

                @Override
                public LofiGalleryInfo[] newArray(int size) {
                    return new LofiGalleryInfo[size];
                }
    };

    public LofiGalleryInfo() {}

    public LofiGalleryInfo(GalleryInfo galleryInfo) {
        gid = galleryInfo.gid;
        token = galleryInfo.token;
        title = galleryInfo.title;
        posted = galleryInfo.posted;
        category = galleryInfo.category;
        thumb = galleryInfo.thumb;
        uploader = galleryInfo.uploader;
        rating = galleryInfo.rating;
        simpleLanguage = galleryInfo.simpleLanguage;
        lofiTags = null;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        int length = lofiTags == null ? 0 : lofiTags.length;
        dest.writeInt(length);
        for (int i = 0; i < length; i++)
            dest.writeString(lofiTags[i]);
    }
}
