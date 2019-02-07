(ns bloggo.frontend.views.root-view
  (:require [bloggo.frontend.views.editor.editor-view :refer [editor]]))

(defn root-view [e! app]
  [:<>
   [editor e! (:current-post app)]])

