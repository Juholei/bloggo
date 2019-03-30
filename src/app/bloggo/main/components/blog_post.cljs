(ns bloggo.main.components.blog-post
  (:require [bloggo.main.markdown :as md]
            [bloggo.main.routes :as routes]))

(defn blog-post
  "Display a blog post"
  [{:keys [post title date] :as post-data}]
  [:div.post-container
   [:h1 title]
   (md/markdown->hiccup post)])

(defn post-preview
  "Display first paragraph of post alongside link to full post"
  [{:keys [post title date id] :as post-data}]
  [:div
   [:a {:href (routes/href ::routes/post {:post-id id})}
    [:h1 title]]
   (md/markdown->hiccup post)])
