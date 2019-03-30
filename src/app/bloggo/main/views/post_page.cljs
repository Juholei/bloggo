(ns bloggo.main.views.post-page
  (:require [bloggo.main.components.blog-post :as blog-post]))

(defn post-page [current-post]
  [:<>
   [blog-post/blog-post current-post]])

