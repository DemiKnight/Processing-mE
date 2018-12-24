package com.krypticalKnight.processingMe.util;

import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.parser.JSONParser;

public class WorldPhraser extends JSONParser {

    public WorldPhraser(String source, Global global, boolean dualFields) {
        super(source, global, dualFields);
    }
}
