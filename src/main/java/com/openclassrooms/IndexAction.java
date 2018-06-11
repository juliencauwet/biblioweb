/*
 * Copyright 2006 The Apache Software Foundation.
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
package com.openclassrooms;


import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import wstarget.openclassrooms.biblioback.ws.*;

/**
 * 
 */
@Conversion()
public class IndexAction extends ActionSupport {

    BooksPortService service = new BooksPortService();


    private Date now = new Date(System.currentTimeMillis());
    
    @TypeConversion(converter = "com.openclassrooms.DateConverter")
    public Date getDateNow() { return now; }
    
    public String execute() throws Exception {

        return SUCCESS;
    }


}
