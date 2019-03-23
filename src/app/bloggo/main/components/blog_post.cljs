(ns bloggo.main.components.blog-post
  (:require [bloggo.main.markdown :as md]))


(defn blog-post
  "Display a blog post"
  [{:keys [post title date] :as post-data}]
  [:div.post-container
   [:h1 title]
   (md/markdown->hiccup post)])

(defn post-preview
  "Display first paragraph of post alongside link to full post"
  [{:keys [post title date] :as post-data}]
  [:div
   [:a {:href "#"}
    [:h1 title]]
   (->> post
        md/markdown->hiccup
        (md/take-elements 1))])
