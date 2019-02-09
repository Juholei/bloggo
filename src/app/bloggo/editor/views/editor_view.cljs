(ns bloggo.editor.views.editor-view
  (:require [bloggo.editor.views.components.preview :refer [preview]]
            [bloggo.editor.views.components.input-box :refer [input-box]]))

(defn editor [e! editable-content]
  [:div.editor-container
   [input-box e! editable-content]
   [preview editable-content]])
