#!/usr/bin/env bash
serverless deploy
serverless client deploy --no-confirm --no-config-change --no-policy-change --no-cors-change
