(ns bloggo.main.components.blog-post
  (:require [bloggo.main.markdown :as md]
            [bloggo.main.routes :as routes]))

(defn blog-post
  "Display a blog post"
  [{:keys [content title] :as post}]
  [:div.post-container
   [:h1 title]
   (md/markdown->hiccup content)])

(defn post-preview
  "Display first paragraph of post alongside link to full post"
  [{:keys [content title date id] :as post}]
  [:div
   [:a {:href (routes/href ::routes/post {:post-id id})}
    [:h1 title]]
   (md/markdown->hiccup content)])
