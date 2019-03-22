(ns bloggo.editor.views.components.preview
  (:require [bloggo.main.markdown :as md]))

(defn preview [markdown-string]
  [:div.editor-sub-view
   (md/markdown->hiccup markdown-string)])

