(ns bloggo.editor.core
  (:require [bloggo.editor.views.editor :refer [editor-page]]
            [bloggo.main.routes :as routes]
            [bloggo.main.view-resolver :as v]))

(defmethod v/root-view ::routes/editor [app e!]
  [editor-page e! (:new-post app)])
