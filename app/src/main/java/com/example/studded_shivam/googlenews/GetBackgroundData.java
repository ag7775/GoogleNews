package com.example.studded_shivam.googlenews;

import java.util.List;

/**
 * Created by StudDed_SHIVAM on 19-Sep-17.
 */

public class GetBackgroundData
{
    public static List<News> data;

    public static List<News> getData() {
        return data;
    }

    public static void setData(List<News> data) {
        GetBackgroundData.data = data;
    }
}
