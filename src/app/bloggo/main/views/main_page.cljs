(ns bloggo.main.views.main-page
  (:require [bloggo.main.components.blog-post :as blog-post]
            [bloggo.main.components.paginator :as p]
            [bloggo.main.routes :as routes]))

(defn select-page! [page-num]
  (routes/href ::routes/page {:page-number page-num}))

(defn main-page [posts current-page page-count]
  [:<>
   [:h1 "Bloggo Blog Platform - Disrupting blogosphere since 20xx"]
   [:div.posts
    (for [post-data posts]
      ^{:key (:title post-data)}
      [blog-post/post-preview post-data])]
   [p/paginator current-page page-count select-page!]])
