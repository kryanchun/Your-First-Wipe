package com.example.android.your_first_swipe.data;

import android.net.Uri;
import android.provider.BaseColumns;

public final class CreditContract {
    private CreditContract(){};

    public static final String CONTENT_AUTHORITY = "com.example.android.your_first_swipe";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_PETS = "creditCards";

    public static final class CreditEntry implements BaseColumns{

        public final static String TABLE_NAME = "creditCards";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_CARD_NAME ="name";
        public final static String COLUMN_CARD_COMPANY = "company";
        public final static String COLUMN_CARD_GENDER = "gender";
        public final static String COLUMN_PET_WEIGHT = "weight";

        public final static int SELECT =0;

        public final static int YES = 1;
        public final static int NO = 2;

        public final static int EXCELLENT = 1;
        public final static int GOOD = 2;
        public final static int FAIR = 3;
        public final static int POOR = 4;
        public final static int DONTKNOW = 5;

        public final static int CREDITBUILD = 1;
        public final static int REWARDS = 2;
        public final static int NOPURPOSE = 3;




        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);

    }
}