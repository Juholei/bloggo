(ns bloggo.editor.views.components.preview
  (:require [markdown-to-hiccup.core :as md]))

(defn preview [markdown-string]
  [:div.editor-sub-view
   (-> markdown-string
       md/md->hiccup
       md/component)])

