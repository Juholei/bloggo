(ns bloggo.lambda.core)

(defn echo [e ctx cb]
  (cb nil (clj->js {:statusCode 200
                    :body "moi"})))



