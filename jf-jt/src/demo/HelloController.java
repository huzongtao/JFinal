/*
 * RT MAP, Home of Professional MAP
 * Copyright 2017 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package demo;

import com.jfinal.core.Controller;

/**
 * @author huzongtao@rtmap.com
 * @package com.demo
 * @date 07/08/2017
 */
public class HelloController extends Controller {

    public void index(){
        renderText("欢迎来到JFinal世界！");
    }
}
