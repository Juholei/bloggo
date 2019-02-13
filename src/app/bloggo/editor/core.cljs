(ns bloggo.editor.core
  (:require [reagent.core :as r]
            [tuck.core :as t]
            [bloggo.editor.views.editor-view :refer [editor]]
            [bloggo.main.routes :as routes]
            [bloggo.main.core :as c]))

(defmethod c/root-view ::routes/editor [app e!]
  [:<>
   [editor e! (:current-post app)]])
