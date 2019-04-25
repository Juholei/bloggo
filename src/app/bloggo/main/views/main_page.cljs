(ns bloggo.main.views.main-page
  (:require [bloggo.main.components.blog-post :as blog-post]
            [bloggo.main.components.paginator :as p]))

(defn main-page [posts]
  [:<>
   [:h1 "Bloggo Blog Platform - Disrupting blogosphere since 20xx"]
   [:div.posts
    (for [post-data posts]
      ^{:key (:title post-data)}
      [blog-post/post-preview post-data])]
   [p/paginator 2 (fn [page-num]
                    (bloggo.main.routes/href :bloggo.main.routes/page {:page-number page-num}))]])
