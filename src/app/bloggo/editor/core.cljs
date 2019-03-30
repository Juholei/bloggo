(ns bloggo.editor.core
  (:require [reagent.core :as r]
            [tuck.core :as t]
            [bloggo.editor.views.editor-view :refer [editor]]
            [bloggo.main.routes :as routes]
            [bloggo.main.view-resolver :as v]))

(defmethod v/root-view ::routes/editor [app e!]
  [:<>
   [editor e! (:new-post app)]])
