(ns bloggo.editor.core
  (:require [reagent.core :as r]
            [tuck.core :as t]
            [bloggo.editor.views.editor :refer [editor-page]]
            [bloggo.main.routes :as routes]
            [bloggo.main.view-resolver :as v]))

(defmethod v/root-view ::routes/editor [app e!]
  [editor-page e! (:new-post app)])
