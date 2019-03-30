(ns bloggo.main.views.main-page
  (:require [bloggo.main.components.blog-post :as blog-post]))

(defn main-page [posts]
  [:<>
   [:h1 "Bloggo Blog Platform - Disrupting blogosphere since 20xx"]
   [:div.posts
    (for [post-data posts]
      ^{:key (:title post-data)}
      [blog-post/post-preview post-data])]])
