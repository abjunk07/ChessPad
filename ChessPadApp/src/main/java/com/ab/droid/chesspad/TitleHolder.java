package com.ab.droid.chesspad;

import com.ab.pgn.Pair;

import java.util.List;

/**
 *
 * Created by abootman on 11/27/16.
 */

interface TitleHolder {
    int getLength();
    void onTitleClick();
    List<Pair<String, String>> getTags();
}
