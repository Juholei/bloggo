(ns bloggo.frontend.views.editor.editor-view
  (:require [bloggo.frontend.views.editor.components.preview :refer [preview]]
            [bloggo.frontend.views.editor.components.input-box :refer [input-box]]))

(defn editor [e! editable-content]
  [:div.editor-container
   [input-box e! editable-content]
   [preview editable-content]])
