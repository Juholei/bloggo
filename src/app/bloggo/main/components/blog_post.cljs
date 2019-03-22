(ns bloggo.main.components.blog-post
  (:require [bloggo.main.markdown :as md]))


(defn blog-post [{:keys [post title date] :as post-data}]
  [:div.post-container
   [:h1 title]
   (md/markdown->hiccup post)])
