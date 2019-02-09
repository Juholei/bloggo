(ns bloggo.editor.views.root-view
  (:require [bloggo.editor.views.editor-view :refer [editor]]))

(defn root-view [e! app]
  [:<>
   [editor e! (:current-post app)]])

