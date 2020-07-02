// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.util.Date;
import com.google.sps.models.Comment;

@WebServlet("/comments")
public class CommentsController extends HttpServlet {
  private List<Comment> comments;

  @Override
  public void init() {
    comments = new ArrayList<>();
    for(Integer i = 0; i < 5; i++){
      comments.add(0, new Comment("Foo", "Bar", new Date()));
    }
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/json;");

    Gson gson = new Gson();
    String data = gson.toJson(comments);

    response.getWriter().println(data);  
  }
}