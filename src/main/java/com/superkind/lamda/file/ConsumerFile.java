package com.superkind.lamda.file;

import jdk.nashorn.internal.objects.annotations.Function;

@FunctionalInterface
public interface ConsumerFile {
    public void fileHanlder(String content);

}
